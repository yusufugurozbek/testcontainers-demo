mvn-clean-install:
	mvn clean install -DskipTests

mvn-run:
	mvn spring-boot:run -Dspring-boot.run.profiles=dev -Pdev

mvn-test:
	mvn clean test
