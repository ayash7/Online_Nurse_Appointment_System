all: compile execute

compile:
	mvn compile

execute:
	java @spring_boot.argfile com.ayash7.online_nurse_appointment_system.OnlineNurseAppointmentSystemApplication

clean:
	rm -r target/classes/com/ayash7/online_nurse_appointment_system/*