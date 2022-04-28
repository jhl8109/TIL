#include "sys/types.h"
#include <stdio.h>
#include <stdlib.h>
#include <utmpx.h>
#include <unistd.h>
#include <string.h>

int main(int argc, char * argv[]) {
	struct utmpx *utx;
	char buf[1024];
	char username[100];
	char hostname[100];
	char file[100]= "/dev/";
	FILE *fp;
	gethostname(hostname,100);
	getlogin_r(username,100);
	while((utx=getutxent()) != NULL) {
		char user[32],line[32];
		memcpy(user,utx->ut_user,32);
		memcpy(line,utx->ut_line,32);	
		if(utx->ut_type != USER_PROCESS||strcmp(argv[1],user)!=0)
			continue;
		strcat(file,line);	
		if((fp=fopen(file,"w")) == NULL) {
			fprintf(stderr,"file open error\n");
			exit(1);
		}
		fprintf(fp,"Message from %s@%s\n",username,hostname);
		while(1) {
			fgets(buf,1024,stdin);
			fprintf(fp,"%s",buf);
		}	
	}
	return 0;
}
