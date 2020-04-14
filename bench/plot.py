import os
import sys
from os.path import isfile, isdir

import matplotlib.pyplot as plt
import csv


dataDir = sys.argv[1]


def get_files():
    benchs = [x for x in os.listdir(dataDir) if isdir(dataDir + x)]

    res = {}
    for b in benchs:
        files = [x for x in os.listdir(dataDir + b) if isfile(dataDir + b + "/" + x) and x.endswith(".csv")]
        res[b] = files

    return res


def get_platform_name(dir: str):
    if dir.startswith("Java"):
        return "HotSpot"
    elif dir.startswith("Kotlin"):
        return "K/Native"
    elif dir.startswith("Substrate"):
        return "SVM"
    else:
        "Unknown"


def main():
    files = get_files()

    for i in files.keys():
        plt.clf()
        for file in files[i]:
            y = []
            reader = csv.reader(open(dataDir + i + "/" + file))
            for r in reader:
                if int(r[1]) > 100:
                    break
                y.append(int(r[2]))

            plt.plot(y, "-", label=get_platform_name(file))

        plt.legend()
        plt.savefig(dataDir + i, dpi=100)


if __name__ == "__main__":
    main()

