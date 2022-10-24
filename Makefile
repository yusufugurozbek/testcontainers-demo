pull-postgres:
	docker pull postgres

run-postgres:
	docker run \
		--name testcontainersDemoPostgresDb \
		-p 5432:5432 \
		-e POSTGRES_USER=postgres \
		-e POSTGRES_PASSWORD=root \
		-e POSTGRES_DB=testcontainersDemoDb \
		-d postgres

start-postgres:
	docker start testcontainersDemoPostgresDb

stop-postgres:
	docker stop testcontainersDemoPostgresDb

delete-postgres:
	docker stop testcontainersDemoPostgresDb
	docker rm testcontainersDemoPostgresDb

mvn-clean-install:
	mvn clean install -DskipTests

mvn-run-with-postgresql:
	mvn spring-boot:run -Dspring-boot.run.profiles=dev

mvn-run-with-h2:
	mvn spring-boot:run -Dspring-boot.run.profiles=dev-h2 -Pdev-h2
