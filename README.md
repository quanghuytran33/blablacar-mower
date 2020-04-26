# blablacar-mower

## Requirements
* Git
* Java 8
* Maven 3.6

## How to launch

Download the code source from gitlab:
```
git clone https://github.com/quanghuytran33/blablacar-mower.git
```

Generate package Java with this code:
``` 
mvn clean install
```

Then launch the application and specify the file's path you want to process.
You can also specify the thread pool size but is not mandatory.    
``` 
java -DfileName={filePath} -DpoolSize={poolSize} -jar target/blablacar-mower-1.0-SNAPSHOT-jar-with-dependencies.jar
```

For reminder, the file must respect this syntax
``` 
5 5 //Lawn length width for 1st line and followed by mowers information
1 2 N // Mower coordinates and orientation
LFLFLFLFF // Commands L: Left, R: Right, F: Forward
3 3 E
FFRFFRFRRF
``` 
