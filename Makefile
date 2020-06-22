BIN_DIR = bin/
DOC_BIN = doc/
C = javac -g -d $(BIN_DIR)
RM = rm
JVM = java
JD = javadoc -d $(DOC_BIN)

SRC_DIR = src/
CONTROLLERS_DIR = src/Controller/
VIEW_DIR = src/View/
MODEL_DIR = src/Model/
DEVICES_DIR = src/Model/devices/

start : src/Start.java Models Controllers Views
		$(C) src/Start.java

Models : $(DEVICES_DIR)Device.java $(DEVICES_DIR)PlayingRemote.java $(DEVICES_DIR)Headset.java $(DEVICES_DIR)Phone.java $(DEVICES_DIR)Sensor.java $(DEVICES_DIR)Tablet.java $(DEVICES_DIR)Webcam.java $(MODEL_DIR)User.java $(MODEL_DIR)Borrow.java
		$(C) $(DEVICES_DIR)Device.java $(DEVICES_DIR)PlayingRemote.java $(DEVICES_DIR)Headset.java $(DEVICES_DIR)Phone.java $(DEVICES_DIR)Sensor.java $(DEVICES_DIR)Tablet.java $(DEVICES_DIR)Webcam.java $(MODEL_DIR)User.java $(MODEL_DIR)Borrow.java

Controllers : $(CONTROLLERS_DIR)BorrowsController.java $(CONTROLLERS_DIR)DevicesController.java $(CONTROLLERS_DIR)UsersController.java $(CONTROLLERS_DIR)StorageController.java 
		$(C) $(CONTROLLERS_DIR)BorrowsController.java $(CONTROLLERS_DIR)DevicesController.java $(CONTROLLERS_DIR)UsersController.java $(CONTROLLERS_DIR)StorageController.java 

Views : $(VIEW_DIR)BorrowView.java $(VIEW_DIR)DevicesView.java $(VIEW_DIR)MenuView.java $(VIEW_DIR)StorageView.java
		$(C) $(VIEW_DIR)BorrowView.java $(VIEW_DIR)DevicesView.java $(VIEW_DIR)MenuView.java $(VIEW_DIR)StorageView.java


play: start
	$(JVM) -cp $(BIN_DIR) src/Start

clean : 
	$(RM) -Rf $(BIN_DIR)$(SRC_DIR)*.class $(BIN_DIR)$(CONTROLLERS_DIR)*.class $(BIN_DIR)$(VIEW_DIR)*.class $(BIN_DIR)$(MODEL_DIR)*.class $(BIN_DIR)$(DEVICES_DIR)*.class $(DOC_BIN)*

doc : 
	$(JD) $(SRC_DIR)*.java $(CONTROLLERS_DIR)*.java $(MODEL_DIR)*.java $(VIEW_DIR)*.java $(DEVICES_DIR)*.java

.PHONY : doc clean

#clear && make clean && make play