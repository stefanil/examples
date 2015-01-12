#JMS Example
Example for implementing a Queue (Point-to-Point) using Apache CXF (for explanation see [Tortsen Horn's tech docs](http://www.torsten-horn.de/techdocs/jee-jms.htm "Tortsen Horn's tech docs")).

##Technology Stack
* Apache ActiveMQ .. JMS implementation
* Apache Camel .. define routing and mediation rules (used by Apache ActiveMQ)
* Spring Beans / Jetty XBeans Integration .. ActiveMQ + Jetty Configuration