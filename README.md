# Kotlin-Native vs Substrate VM benchmark


## Installation
1. You need to install [Windows SDK](https://www.microsoft.com/en-us/download/details.aspx?id=8442)
2. Don't forget to install JDK. This benchmark works great with OpenJDK-12.0.2
3. Clone this repo
4. If you would to plot benchmark results, you should to install [python3] (https://python.org) and do next:
```
Windows: pip install matplotlib
Unix: pip3 install matplotlib
```

## Build benchmarks
1. For KN (Windows only, but you can configure this in `build.gradle`):
```
gradlew mingwMainBinaries
```
2. For SVM:
```
gradlew nativeImage
```
3. Pure JVM:
```
gradlew jvmJar
```
(KN command automatically runs `gradlew jvmJar` command)

## Runing benchmarks
1. Run one of the binary
2. Select bench (using numbers 0-5, separated with SPACE or `enb` for run all benchs with `+` mark or `all` for run all benchs)

![](https://habrastorage.org/webt/mc/kg/fo/mckgfoijdmht-uvqi4fwesozwu4.png)

3. After it done, directories and files will generated in ./bench/ directory
4. For plotting diagrams of benchmark results, you should to run `plot.py`:
```
python3 ./bench/plot.py ./bench/
```

For getting statistics, you should to run `getStat.py`:
```
python3 ./bench/getStat.py ./bench/
```
Where `./bench/` args set the results directory

![](https://habrastorage.org/webt/km/oz/ko/kmozkojuqke2rgko7izprdlluhu.png)

*this image builded for two versions of KN; if you would to do something like this, you should to modify plot.py file*
