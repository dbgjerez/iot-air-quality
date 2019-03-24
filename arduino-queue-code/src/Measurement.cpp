#include "Measurement.h"

String Measurement::toJson() const
{
    String res("{");
    res.concat("\"type\": \"");
    res.concat(type());
    res.concat("\"");

    res.concat(", \"datetime\": ");
    res.concat(datetime);
    res.concat("}");
    return res;
}