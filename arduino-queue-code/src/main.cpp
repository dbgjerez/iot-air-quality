#include <Arduino.h>
#include <Ethernet.h>

#include "Measurement.h"
#include "PubSubClient.h"
#include <Ethernet.h>

using namespace std;

static byte mac[] = {0x90,0xA2,0xDA,0x00,0x69,0x7C};

static IPAddress mqttServer(192, 168, 1, 49);
static int mqttPort(1883);
static const char* clientName = "iot";
static const char* user = "user";
static const char* password = "prueba01";
static const char* routingKey = "mq2";
static EthernetClient client;
static PubSubClient mqttClient(client);

void setup() {
  Serial.begin(9600);
  Ethernet.begin(mac);
  mqttClient.setServer(mqttServer, mqttPort);
}

void loop() {
  if(!mqttClient.connected()){
    Serial.println("Conectando...");
    mqttClient.connect(clientName, user, password);
  } else{
    const Measurement m = Measurement("temperature");
    const String mJson = m.toJson();
    Serial.println("Enviando a la cola: " + mJson);
    mqttClient.publish(routingKey, mJson.c_str());
  }
  delay(5000);
}
