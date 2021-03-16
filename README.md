# ibanverificationservice1

1st service from task, which verifies IBAN numbers and checks if concrete IBAN belongs for SEB.

 ### service endpoints:
 
 - iban/v1/{iban} 
 - iban/v2/{iban}
 
 where: 
  
  - v1 endpoint validates IBAN as per  ISO/IEC 7064, IBAN lengts and it's country code.
  - v2 endpoint validates IBAN as per  ISO/IEC 7064, IBAN lengts and it's country code and checks if IBAN belongs for SEB.


Service is configured to run on 8081 port by default.

to run the service on Your computer use command in CMD or BASH:
**./gradlew bootRun** from ibanverificationservice1 folder after spurce code was cloned or downloaded and extracted.

Example requests after service is running:

  - **http://localhost:8081/iban/v1/LT517044077788877777**
  - **http://localhost:8081/iban/v2/LT517044077788877777**
  

***Request can be made with the help of Postman, Curl or any browser***
