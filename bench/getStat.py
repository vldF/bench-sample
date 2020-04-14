import csv

from plot import get_files, get_platform_name, dataDir


def main():
    files = get_files()

    for i in files.keys():
        by_platform = []
        for file in files[i]:
            y = []
            reader = csv.reader(open(dataDir + i + "/" + file))
            for r in reader:
                y.append(int(r[2]))

            min_val = min(y)
            max_val = max(y)

            y = sorted(y)
            y = y[:-10]

            avg = sum(y) / len(y)

            by_platform.append((get_platform_name(file), avg, max_val, min_val))

        print(i)
        for p in by_platform:
            print(p[0], ":", "min", p[3] // 1000, "Ms, max", p[2] // 1000, "Ms, avg ", p[1] // 1000,  "Ms")
        print()


if __name__ == "__main__":
    main()
