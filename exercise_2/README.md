Bonita rest api extension + custom page
============


this project contains 2 modules:
* custom-lib: a simple library that generate Pokemons
* rest-api-extension: a rest api extension that return a pokemon using the library

### Start a bonita

You can stat a bonita docker using
```
docker run -v you_lic_folder:/opt/bonita_lic -p 8080:8080 registry.rd.lan/bonita-sp:7.6.0
``` 

### Deploy the rest api extension

use

```
gradle deployAllBonitaArtifacts
``` 

this should deploy on the bonita the rest api extension containing the library

### Continuous deploy

you can use continuous build to deploy the rest api extension on change.

```
gradle deployAllBonitaArtifacts -t
```

### Add a custom page that call the rest api extension and display it

see how to use deployer works plugin here:

https://github.com/bonitasoft/bonita-resources-deployer#gradle-plugin


### Plugin development

create a plugin that put in the build directory a file `dependency.txt` that contains
the dependencies of the module.

The `dependency.txt` file should be created when calling `build` task

the task should not be re-executed when there is no changes 
 
 (you can modify the one in buildSrc) 