"# FlowDrive"
 

I have automated few functionalities of FlowDrive Application with Appium using local device(Android).



prerequisites :
---------------
1) Set up Appium and Eclipse
2) TestNG - Report generation and execution.
3) Apache POI
4) Use android device having version >4.2


Details:
---------
* Apps/FlowApp -> contains the apk file.

* src -> contains 3 floders (FlowDriveApp, RegressionSuite, TestData)

* FlowDriveApp -> contains all the automated test scripts

* RegressionSuite -> contains 3 regression suites(.xml files) each focusing on particular flow(functionalities) 
                     either valid or invalid. 
                     please run either of the suites as **TestNg Suite.

* TestData -> contains the Excel sheet from where the data is read.



Important :
-------------

* please input the DeviceName and Platform Version of the android device which you will be using 
  in Testdata excel - AndroidDetails sheet before executing any of the regression suite.


Automated Scenarios :
----------------------

1) LaunchandRegistration_ValidScenario --> This regression suite will launch the FlowDrive app in local device, agree to
                                           terms and conditions. Then creates an account by inputting all details from excel
                                           and logs in.

2) Login_InvalidScenarios --> This regression suite will Launch FlowDrive and try to Login with invalid details.
                               Appropriate error messages are validated.

3) NavigationtoAllPageandSendFeedback  --> This regression suite first launches the application and logs in with valid details.
                                           Then clicks on Start and Cancel journey.
                                           Navigates to all the Tabs.
                                           Finally clicks on feedback button on Home Page and sends appropriate feeedback
                                           via Gmail.




Test Reports:
----------------

* Once after the suite is run the result Reports are generated in Test_Output folder(index.html).

