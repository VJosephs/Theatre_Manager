
class_name = input("Enter a class name or 'quit' to exit: ")
while class_name != 'quit':
    out_file = open("{}.java".format(class_name), 'w')

    out_file.write("public class {}".format(class_name))
    out_file.write(" {\n\n\n}")

    out_file.close()
    class_name = input("Enter a class name or 'quit' to exit: ")
