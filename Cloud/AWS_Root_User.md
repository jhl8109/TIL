## Protect the AWS Root User

Authentication and authorization, these two terms come up frequently. Though these therms may seem basic, you need to understand them to properly configure access management on AWS

##### Understand Authentication(인증)

If the user types in the correct email and password, the system assumes the user is allowed to enter and grants them access. This is the process of authentication.

##### Understand Authorization(권한)

Authorization is the process of giving users permission to access AWS resources and serviices.

##### AWS Root User

The AWS root user has authentication and authorization. This user has complete access to all AWS services and resources in the account. This identity us called the AWS root user and is accessed by signing in with the email address and password that you used to create the account.

##### The AWS root user credentials 

The AWS root user has two sets of credentials associated with it. One set of credentials is the email address and password used to create the account. This allows you to access the AWS Management Console. The second set of credentials is called access keys, which allow you to make programmatic requests from the AWS Command Line Interface (AWS CLI) or AWS API.
Similar to a username and password combination, you need both the access key ID and secret access key to authenticate your requests via the AWS CLI or AWS API. Access keys should be managed with the same security as an email address and password.

##### Best Way to use thw AWS Root User

Securely lock away the credentials associated with the root user and do not use th eoot user for everyday tasks.

* Choose a strong password for the root user.
* Never share root user account.
* Disable or delete the access keys associated with the root user.
* Do not use for administrative tasks or everyday dasks.


##### Multi-Factor Authentication (MFA)

Single-factor authentication - Use username and password to authenticate (pin or token too)
Multi-factor authentication - two or more authentication methods to verify an identity.

##### MFA on AWS

If you want to enable MFA on your root user, you are required to enter an email and password as well as temporary numeric code provided by an MFA device.
There are three kind of MFA devices.
* Virtuarl MFA - A software app that runs on a phone or other device that provides a one-time passcode, but not safe as hardware of U2F/
* Hardware - A hardware device, generally a key fob or display card device that generates a one-time six-digit numeric code.
* U2F - A hardware device that you plug into a USB port on your computer





