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

inline Measurement::Measurement(){};
inline Measurement::Measurement(String type) : type_(type){};
inline String Measurement::type() const { return type_; }
inline Measurement::~Measurement(){};

#endif