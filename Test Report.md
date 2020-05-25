# Nochi.com test report
## This is a test report for testing activities for project Nochi.com.
### Testing was performed on environment Windows 10 Pro, notebook Lenovo ThinkPad e14, Chrome ver. 81.0.4044, Java 1.8.0_241.
Testing was provided by developing autotest for checking information about room booking on specified dates and about people number.
In the scope of performed functional testing, on the Knickerbocker Hotel example, was discovered, that there is no
information about the quantity of the guests on the checkout page, but dates displayed correctly,
which was verified by successful autotest execution.
Also, was discovered, that the front part of the site has minor instability, that is expressed in the need
of additional waiters at pages and elements interactions, though this issue is not very serious.
#### As a QA specialist, I cannot recommend deploy of this build, because of the issue in the main logic of the functionality - missing information about the number of the guests and their membership, especially it can be critical for children under age of 10.

##### Additional technical information.
Location of chromedriver was hardcoded on path "C:\Users\User". Screenshots and logs packages are generating and storing in the root of the project. Also, added Allure reports functionality to project configuration, that can be viewed after tests execution by command mvn allure:serve.
