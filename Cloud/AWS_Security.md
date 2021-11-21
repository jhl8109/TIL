## AWS Security



#### 보안의 책임은 누구에게 있는가??
* 나, AWS 둘 다 책임이 있다 (= Shared Responsibility model)

#### AWS 의 책임
* Region, Availability Zone , data center 등 자역적 보안
* hardware,software,networking,host operating systems, virtualization layer 보안


#### 사용자의 책임
* 적절한 서비스, 애플리케이션의 구성이 필요하다.

Infrastructure > Container > Abstracted 으로 사용자가 부담해야할 관리가 줄어든다.

|Category|AWS Responsibility|User Responsibility|
|:---:|:---:|:---:|
|Infrastructure services|AWS manages the infrastructure and foundation services.|You control the operating system and application platform, as well as encrypting, protecting, and managing customer data.|
|Container services|AWS manages the infrastructure and foundation services, operating system, and application platform.|You are responsible for customer data, encrypting that data, and protecting it through network firewalls and backups.|
|Abstracted services|AWS operates the infrastructure layer, operating system, and platforms, as well as server-side encryption and data protection.|You are responsible for managing customer data and protecting it through client-side encryption.|

2021-11-21 참고
https://www.coursera.org/learn/aws-cloud-technical-essentials/supplement/6UN7b/reading-1-5-security-and-the-aws-shared-responsibility-model
