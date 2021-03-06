/**
 * Created by Mengqi on 15/2/8.
 Compare two version numbers version1 and version2.
 If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

 You may assume that the version strings are non-empty and contain only digits and the . character.
 The . character does not represent a decimal point and is used to separate number sequences.
 For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

 Here is an example of version numbers ordering:

 0.1 < 1.1 < 1.2 < 13.37
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");

        int maxLength = Math.max(split1.length, split2.length);
        for (int i = 0; i < maxLength; i++) {
            int i1 = i<split1.length ? Integer.parseInt(split1[i]):0;
            int i2 = i<split2.length ? Integer.parseInt(split2[i]):0;
            if (i1 != i2) {
                return i1 - i2 > 0 ? 1 : -1;
            } else { //i1 == i2
                continue;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersionNumbers compareVersionNumbers = new CompareVersionNumbers();
        System.out.println(compareVersionNumbers.compareVersion("2.3.4", "2.3.4"));
    }
}
