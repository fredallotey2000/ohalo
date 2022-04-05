/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ohalo.service;

import java.util.ArrayList;
import java.util.List;

public class SearchUtil {

    /*entry point to search target string, 
    splits the target string into 4(can be increased to increase speed of search) equal parts */
    public static List<int[]> searchTarget(String targetStr, String searchStr, boolean isCaseSensitive) {
        String[] targetArray = new String[4];
        if (targetStr.length() > 500) {
            String[] splitTarget = splitTarget(targetStr);
            String[] split1 = splitTarget(splitTarget[0]);
            String[] split2 = splitTarget(splitTarget[1]);
            targetArray[0] = split1[0];
            targetArray[1] = split1[1];
            targetArray[2] = split2[0];
            targetArray[3] = split2[1];
        } else {
            String[] splitTarget = splitTarget(targetStr);
            targetArray[0] = splitTarget[0];
            targetArray[1] = splitTarget[1];
        }
        List<int[]> findInTarget = findInTarget(targetArray, searchStr, isCaseSensitive);
        return findInTarget;
    }

    /*Finds the entry string in the target string
    searches through 4 strings at the same time
    return the list of indices of start and end index of found string*/
    public static List<int[]> findInTarget(String[] splitTarget, String searchStr, boolean isCaseSensitive) {
        List<int[]> indicesArray = new ArrayList<>();
        String str1 = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int offset = 0;
        int offset2 = 0;
        int offset3 = 0;
        int offset4 = 0;
        if (splitTarget[0] != null) {
            if (!isCaseSensitive) {
                str1 = splitTarget[0].toLowerCase();
            } else {
                str1 = splitTarget[0];
            }
            offset = str1.length();
        }
        if (splitTarget[1] != null) {
            if (!isCaseSensitive) {
                str2 = splitTarget[1].toLowerCase();

            } else {
                str2 = splitTarget[1];
            }
            offset2 = str2.length();
        }
        if (splitTarget[2] != null) {
            if (!isCaseSensitive) {
                str3 = splitTarget[2].toLowerCase();
            } else {
                str3 = splitTarget[2];
            }
            offset3 = str3.length();
        }
        if (splitTarget[3] != null) {
            if (!isCaseSensitive) {
                str4 = splitTarget[3].toLowerCase();

            } else {
                str4 = splitTarget[3];
            }
            offset4 = str4.length();

        }
        String entry = null;
        if (!isCaseSensitive) {
            entry = searchStr.toLowerCase();
        } else {
            entry = searchStr;
        }
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);

        int searchStrLen = 0;
        int[] indices;
        int index = 0;
        int index2 = 0;
        int index3 = 0;
        int index4 = 0;
        while (index != -1 || index2 != -1 || index3 != -1 || index4 != -1) {
            if (str1 != null && index != -1) {
                index = str1.indexOf(entry, index + searchStrLen);  // Slight improvement
                searchStrLen = searchStr.length() - 1;
                if (index != -1) {
                    indices = new int[2];
                    indices[0] = index;
                    indices[1] = index + searchStrLen;
                    indicesArray.add(indices);
                }
            } else {
                index = -1;
            }
            if (str2 != null && index2 != -1) {
                index2 = str2.indexOf(entry, index2 + searchStrLen);
                searchStrLen = searchStr.length() - 1;
                if (index2 != -1) {
                    indices = new int[2];
                    indices[0] = index2 + offset;
                    indices[1] = index2 + offset + searchStrLen;
                    indicesArray.add(indices);
                }
            } else {
                index2 = -1;
            }
            if (str3 != null && index3 != -1) {
                index3 = str3.indexOf(entry, index3 + searchStrLen);
                searchStrLen = searchStr.length() - 1;
                if (index3 != -1) {
                    indices = new int[2];
                    indices[0] = index3 + offset2;
                    indices[1] = index3 + offset2 + searchStrLen;
                    indicesArray.add(indices);
                }
            } else {
                index3 = -1;
            }
            if (str4 != null && index4 != -1) {
                index4 = str4.indexOf(entry, index4 + searchStrLen);
                searchStrLen = searchStr.length() - 1;
                if (index4 != -1) {
                    indices = new int[2];
                    indices[0] = index4 + offset3;
                    indices[1] = index4 + offset3 + searchStrLen;
                    indicesArray.add(indices);
                }
            } else {
                index4 = -1;
            }

        }
        return indicesArray;
    }

//Splites target string into 2 equal strings
    public static String[] splitTarget(String target) {
        String[] array = new String[2];
        String firstHalf = target.substring(0, target.length() / 2);
        int indexOf = firstHalf.lastIndexOf(" ");
        if (indexOf < 1) {
            array[0] = target;
        } else {
            array[0] = target.substring(0, indexOf);
            array[1] = target.substring(indexOf);
        }
        return array;

    }
}
