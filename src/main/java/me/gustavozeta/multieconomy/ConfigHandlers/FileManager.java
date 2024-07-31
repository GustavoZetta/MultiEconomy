package me.gustavozeta.multieconomy.ConfigHandlers;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileManager {
    private String getLog(int LogNum) {
        File file = null;
        YamlConfiguration config = null;
        String prefix = null;

        try {
            file = new File(Bukkit.getUpdateFolderFile().getPath(), "mensagens/log.yml");
            config = YamlConfiguration.loadConfiguration(file);
            prefix = config.getString("prefix");
        } catch (NullPointerException Erro) {
            Bukkit.getLogger().log(Level.WARNING, "Erro carregando as mensagens do log, usando mensagens padrão do plugin (Delete o arquivo para reseta-lo)");
            prefix = "§c[MultiEconomy]§f";
        }

        switch (LogNum) {
            case 404: {
                try {
                    String msg = config.getString("arquivo-inexistente").replace('&', '§');
                    msg.replace("{prefix}", prefix);
                    return msg;
                } catch (NullPointerException Erro) {
                    return prefix + "Erro 404: Arquivo não encontrado";
                }
            }
            case 405: {
                try {
                    String msg = config.getString("configuracao-inexistente").replace('&', '§');
                    msg.replace("{prefix}", prefix);
                    return msg;
                } catch (NullPointerException Erro) {
                    return prefix + "Erro 405: Path YAML não encontrado";
                }
            }
            default: {
                return prefix + "Erro desconhecido, por favor, contate o desenvolvedor do plugin";
            }
        }
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
