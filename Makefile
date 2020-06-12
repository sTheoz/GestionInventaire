BIN_DIR = bin/
C = javac -g -d $(BIN_DIR) -cp $(BIN_DIR)
RM = rm
JVM = java

CONTROLLERS_DIR = src/Controller/
DEVICES_DIR = src/Model/devices/
PEOPLE_DIR = src/Model/people/
VIEW_DIR = src/View/

start : src/Start.java Views Models #Controllers
		$(C) src/Start.java

#Controllers : 
#		$(C) 

Models : $(DEVICES_DIR)Device.java $(DEVICES_DIR)GameController.java $(DEVICES_DIR)Headset.java $(DEVICES_DIR)Phone.java $(DEVICES_DIR)Sensor.java $(DEVICES_DIR)Stock.java $(DEVICES_DIR)Tablet.java $(DEVICES_DIR)Webcam.java
		$(C) $(DEVICES_DIR)Device.java $(DEVICES_DIR)GameController.java $(DEVICES_DIR)Headset.java $(DEVICES_DIR)Phone.java $(DEVICES_DIR)Sensor.java $(DEVICES_DIR)Stock.java $(DEVICES_DIR)Tablet.java $(DEVICES_DIR)Webcam.java

Views : $(VIEW_DIR)BorrowView.java $(VIEW_DIR)DevicesView.java $(VIEW_DIR)StockView.java
		$(C) $(VIEW_DIR)BorrowView.java $(VIEW_DIR)DevicesView.java $(VIEW_DIR)StockView.java


play: start
	$(JVM) -cp $(BIN_DIR) src/Start

clean : 
	$(RM) $(BIN_DIR)*.class