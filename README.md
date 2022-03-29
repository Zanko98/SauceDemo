#команда для просмотра доступных обновлений библиотек
#  mvn versions:display-dependency-updates
org.seleniumhq.selenium:selenium-java ................. 4.1.2 -> 4.1.3

#команда для автоматического обновления всех версий
#  mvn versions:use-latest-versions
Major version changes allowed

#комманда для запуска всех тестов
#  mvn clean test
Tests run: 23, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 104.825 sec

#команда для запуска тестов из класса CartTest
#  mvn test -Dtest=CartTest
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 38.904 s - in tests.CartTest

#команда для запуска метода checkoutButtonTest из класса CartTest
#  mvn test -Dtest=CartTest#checkoutButtonTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 13.301 s - in tests.CartTest

#запуск двух методов из класса HeaderContainerTest
#  mvn -Dtest=HeaderContainerTest#backToProductButtonTest+shoppingCartButtonTest test
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 6.51 s - in tests.HeaderContainerTest

#запуск методов, имена которых заканчиваются на IntoCart
#  mvn "-Dtest=???Test#*IntoCart" test
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 14.186 s - in TestSuite

#запуск файла regression.xml
#  mvn clean test -DsuiteXmlFile=src/test/resources/regression.xml
Tests run: 23, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 79.23 s - in TestSuite

#запуск всех тестов с параметром System.getProperty("user");
#  mvn test -Duser=performance_glitch_user
Tests run: 23, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 168.662 s - in TestSuite


