# IAM

### What is IAM?

IAM is a web service that enables you to manage access to your AWS account and resources.
It also provides that allowed inside your AWS accounts, and who and what have permissions to use and work with your AWS resources.

It makes you can share your set of access keys or password. You can also provide granular access to those working in your accounts.
It means you can granularly select which actions and which resources in that service they can access.

### IAM Features

* You can use your each IAM configurations from any Regions(다른 지역별로 각각 만들어서 쓸 수 있다)
* IAM is integrated with many AWS services.
* IAM supports MFA.

### IAM Group

If the number of users helping you build your solutions on AWS increases, it becomes more complicated to keep up with permissions.

An IAM group is a collection of users. All users in the group inherit the permissions assigned to the group. This makes it easy to give permissions to multiple users at once. It’s a more convenient and scalable way of managing permissions for users in your AWS account. This is why using IAM groups is a best practice.

### IAM Policy

To manage access and provide permissions to AWS services and resources, you create IAM policies and attach them to IAM users, groups, and roles.

{
"Version": "2012-10-17",
    "Statement": [{
        "Effect": "Allow",
        "Action": "*",
        "Resource": "*"
     }]
}
Putting all this information together, you have a policy that allows you to perform all actions on all resources inside your AWS account. This is what we refer to as an administrator policy.

{
"Version": "2012-10-17",
    "Statement": [{
        "Effect": "Allow",
        "Action": [
            "iam: ChangePassword",
            "iam: GetUser"
            ]
        "Resource": "arn:aws:iam::123456789012:user/${aws:username}"
    }]
}
After looking at the JSON, you can see that this policy allows the IAM user to change their own IAM password (iam:ChangePassword) and get information about their own user (iam:GetUser). It only permits them to access their own credentials because the resource restricts access with the variable substitution ${aws:username}.

|Element|Description|Required|Example|
|---|------|---|-----|
|Effect|Specifies whether the statement results in an allow or an explicit deny|✔|"Effect": "Deny"|
|Action|Describes the specific actions that will be allowed or denied|✔|"Action": "iam:CreateUser"|
|Resource|Specifies the object or objects that the statement covers|✔|"Resource": "arn:aws:iam::account-ID-without-hyphens:user/Bob"|

from https://www.coursera.org/learn/aws-cloud-technical-essentials/supplement/6HZ3a/readings-1-7-introduction-to-aws-identity-and-access-management
