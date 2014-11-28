Screensteps Java Client
=======================

A Java client for the [Sceensteps][ss] Rest Service, using Spring's RestTemplate.

Usage
-----

Create a Screensteps instance, passing credentials and domain straight into the constructor. Then use the objects helper methods to pull data from the various endpoints.

      Screensteps screensteps = new Screensteps("user@email.com","password","example-domain");
      Manual manual = screensteps.getManual("1234", "abcd");

A description of the available endpoints can be found [here][api]



[ss]: http://www.screensteps.com
[api]: http://help.screensteps.com/m/screenstepslive-api/pdf
