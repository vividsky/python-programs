string = input()
count = 1
count_list = []
if len(string) == 1:
    print(1)
else:
    for i in range(len(string)-1):
        if string[i+1] == string[i]:
            count += 1
        else:
            count_list.append(count)
            count = 1
        count_list.append(count)
    print(max(count_list))
