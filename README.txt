# SPRING-PROJECT-Main

Add customer---- http://localhost8081/loanapp/customer/add

{
     "password" : "cutomer@12",
     "role" : "customer",
     "customerName": "Karthik",
    "mobileNumber": "9045457223",
    "emailId": "himagani21@gmail.com",
    "dateOfBirth": "2005-04-21",
    "gender": "Male",
    "annualSalary": 560000,
    "aadharNumber": "123456789123",
    "panNumber": "1234567890"
}

Add application----------

{
"applicationDate" : "2023-05-21",
"customer" : {"userId" : 214},
"loanAppliedAmount" : 140000,
"adminApproval" : false,
"status" : "WAITING_FOR_LOAN_APPROVAL"
}



LAD Login---------------

{
    "userId":"ladadmin",
    "password":"pass123"
}



Admin Login---------------

{
    "userId":"admin",
    "password":"root"
}



update application----------


{
    "applicationId": 216,
    "applicationDate": "2023-05-21",
    "customer":{"userId":214},
    "loanAppliedAmount": 140000,
    "loanApprovedAmount": 100000,
    "loanStatusApproval": true,
    "adminApproval": true,
    "status": "WAITING_FOR_LOAN_APPROVAL"
    }

APPROVED----------------

{
    "applicationId": 216,
    "applicationDate": "2021-05-31",
    "customer":{"userId":214},
    "loanAppliedAmount": 140000,
    "loanApprovedAmount": 100000,
    "loanStatusApproval": true,
    "loanStatusApproval": true,
    "adminApproval": true,
    "status": "APPROVED"

}

