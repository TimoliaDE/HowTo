package de.timolia.howto;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.timolia.howto.conversion.InitialConversion;
import de.timolia.howto.generator.FileWriter;
import de.timolia.howto.generator.PageRankChange;
import de.timolia.howto.generator.PageResponsibilities;
import de.timolia.howto.generator.PageTeamMembers;
import de.timolia.howto.models.Teamler;
import de.timolia.howto.translate.Translate;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Dapp {
    public static final Translate translate = new Translate();
    public static final Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();

    public static void main(String[] args) throws Exception {
        Path path = Path.of("docs", "team");
        translate.loadDirectory(path.resolve("translate"));
        String json = Files.readString(path.resolve("teamler.json"), StandardCharsets.UTF_8);
        Teamler[] teamlers = gson.fromJson(json, Teamler[].class);
        List<Teamler> teamlerList = Arrays.asList(teamlers);
        teamlerList.forEach(Teamler::updateName);
        FileWriter fileWriter = new FileWriter(path, translate);
        fileWriter.writeFile("changes", PageRankChange.generate(teamlerList));
        fileWriter.writeFile("members", PageTeamMembers.generate(teamlerList));
        fileWriter.writeFile("responsibilities", PageResponsibilities.generate(teamlerList));
        if (args.length == 1 && args[0].equalsIgnoreCase("init")) {
            InitialConversion.convert();
        }
    }
}
