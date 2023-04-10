# LZW

Basic implementation of the LZW compression algorithm
### Short description:
 * Dictionary - Initialization of a basic dictionary containing Cyrillic, Latin, numbers and special characters, then the Dictionary class is added to the LZW class as a dependency.
 * FileUtils - Utility class for working with files:
* write(String result) - write encrypted string to file
* read() - Read from a file character by character into an array of characters
* writeListToFile(List<Integer> list) - write a list of encoded character sequences to a file
* readListFromFile() - Reading a list from a file


#### Main LZW class:
* compress() - Reads an array of characters from a text file and character-by-character encodes characters or sequences of repeated characters
* decompress() - Method for decompressing a compressed file from a sequence of decompressed characters
