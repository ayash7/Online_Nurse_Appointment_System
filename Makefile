all: compile test execute

run: compile execute

build: install compile test package

compile:
	mvn compile

test:
	mvn test

package:
	mvn clean package

install:
	mvn -U clean install

execute:
	java @spring_boot.argfile com.ayash7.online_nurse_appointment_system.OnlineNurseAppointmentSystemApplication

clean:
	rm -r target/classes/com/ayash7/online_nurse_appointment_system/*