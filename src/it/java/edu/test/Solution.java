package it.java.edu.test;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'countTeams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY skills
     *  2. INTEGER minPlayers
     *  3. INTEGER minLevel
     *  4. INTEGER maxLevel
     */

    public static int countTeams(List<Integer> skills, int minPlayers, int minLevel, int maxLevel) {
        // Validazione dei constraint
        validateConstraints(skills, minPlayers, minLevel, maxLevel);

        // Filtra le abilità che rientrano nel range richiesto
        List<Integer> validSkills = skills.stream()
                .filter(skill -> skill >= minLevel && skill <= maxLevel)
                .collect(toList());

        int validLength = validSkills.size();

        // Usa il metodo combinatorio per contare tutte le combinazioni possibili
        return countCombinations(validSkills, validLength, minPlayers);
    }

    private static void validateConstraints(List<Integer> skills, int minPlayers, int minLevel, int maxLevel) {
        if (skills.size() < 1 || skills.size() > 20) {
            throw new IllegalArgumentException("skills size must be between 1 and 20");
        }
        if (minPlayers < 1 || minPlayers > skills.size()) {
            throw new IllegalArgumentException("minPlayers must be between 1 and the size of skills");
        }
        if (minLevel < 1 || minLevel > 1000) {
            throw new IllegalArgumentException("minLevel must be between 1 and 1000");
        }
        if (maxLevel < minLevel || maxLevel > 1000) {
            throw new IllegalArgumentException("maxLevel must be between minLevel and 1000");
        }
    }

    private static int countCombinations(List<Integer> arr, int n, int r) {
        int count = 0;
        int[] data = new int[r];
        count = combinationUtil(arr, n, r, 0, data, 0, count);
        return count;
    }

    private static int combinationUtil(List<Integer> arr, int n, int r, int index, int[] data, int i, int count) {
        if (index == r) {
            return count + 1;
        }
        if (i >= n) {
            return count;
        }
        data[index] = arr.get(i);
        count = combinationUtil(arr, n, r, index + 1, data, i + 1, count);
        count = combinationUtil(arr, n, r, index, data, i + 1, count);
        return count;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int skillsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> skills = IntStream.range(0, skillsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int minPlayers = Integer.parseInt(bufferedReader.readLine().trim());

        int minLevel = Integer.parseInt(bufferedReader.readLine().trim());

        int maxLevel = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.countTeams(skills, minPlayers, minLevel, maxLevel);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}