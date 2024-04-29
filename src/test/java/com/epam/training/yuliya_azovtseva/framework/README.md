### Running framework task tests

- Launch parameters for tests execution are stored in .properties files:
  
  Use `-Denv` to define the test environment  


- There are two groups of tests `regression` or `smoke`

  Use `-Dtests` to define the tests scope

For example to run tests with default configuration

```commandline
 mvn clean test
```

To run tests in `qa` environment with `smoke` tag

```commandline
 mvn clean test -Denv=qa -Dtests=smoke
```
