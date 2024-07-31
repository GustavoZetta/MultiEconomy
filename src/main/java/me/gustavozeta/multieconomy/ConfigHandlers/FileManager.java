package me.gustavozeta.multieconomy.ConfigHandlers;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileManager {
    private String getLog(int LogNum) {
        boolean defaultMessages = false;
        File file;
        YamlConfiguration config;
        try {
            file = new File(Bukkit.getUpdateFolderFile().getPath(), "mensagens/log.yml");
            config = YamlConfiguration.loadConfiguration(file);
        } catch (NullPointerException Erro) {
            Bukkit.getLogger().log(Level.WARNING, "Erro carregando as mensagens do log, usando mensagens padrão do plugin");
            defaultMessages = true;
        }

        if (defaultMessages == false) {
            switch (LogNum) {
                case 404: {
                    try {
                        return config.getString("");
                    } catch (NullPointerException Erro) {

                    }
                }
                case 405: {

                }
                case 101: {

                }
            }
        }
        return " ";
    }

    public void getFile(String filepath) {
        if (filepath == null || filepath.trim().isEmpty()) { return; }

        if (filepath.endsWith(".yml")) {
            File file = new File(Bukkit.getUpdateFolderFile().getPath(), filepath);

            if (!file.exists()) {
                Bukkit.getLogger().log(Level.WARNING, getLog(404));
                return;
            }
        } else {

        }

    }
}
