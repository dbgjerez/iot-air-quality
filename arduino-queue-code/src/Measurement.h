#ifndef measurement_h
#define measurement_h

#include <Chronos.h>

using namespace std;

class Measurement
{
  private:
    String type_;
    Chronos::EpochTime datetime = Chronos::DateTime::now().asEpoch();
  public:
    Measurement(String type);
    Measurement();
    String type() const;
    String toJson() const;
    ~Measurement();
};

  Measurement::Measurement(){};
  Measurement::Measurement(String type):type_(type){};
  inline String Measurement::type() const {return type_;}
  inline String Measurement::toJson() const {
    String res("{");
      res.concat("\"type\": \"");
      res.concat(type());
      res.concat("\"");

      res.concat(", \"datetime\": ");
      res.concat(datetime);
    res.concat("}");
    return res;
  }
  Measurement::~Measurement(){};

#endif
