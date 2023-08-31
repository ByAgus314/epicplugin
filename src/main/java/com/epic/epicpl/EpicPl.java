
package com.epic.epicpl;

import java.io.File;

import com.epic.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

//commands

//commands

//events
import com.epic.events.EventDeadAzar;
import com.epic.events.EventFirstJoin;
import com.epic.events.EventJoin;
import com.epic.events.EventHammer;
//events


public class EpicPl
extends JavaPlugin {
    public String rutaConfig;
    PluginDescriptionFile pdffile = this.getDescription();
    public String version = this.pdffile.getVersion();



    public void registerConfig() {
        File config = new File(this.getDataFolder(), "config.yml");
        this.rutaConfig = config.getPath();
        if (!config.exists()) {
            this.getConfig().options().copyDefaults(true);
            this.saveConfig();
        }
    }
  //prefix 
    
    public String nombre = (Object)ChatColor.DARK_RED + "\n _______  _______ _________ _______        _______  _       \n" +
            ChatColor.DARK_RED +"(  ____ \\(  ____ )\\__   __/(  ____ \\       (  ____ )( \\      \n" +ChatColor.DARK_RED +
            ChatColor.DARK_RED +"| (    \\/| (    )|   ) (   | (    \\/       | (    )|| (      \n" +ChatColor.DARK_RED +
            ChatColor.DARK_RED +"| (__    | (____)|   | |   | |             |(____)|| |      \n" +ChatColor.DARK_RED +
            ChatColor.DARK_RED +"|  __)   |  _____)   | |   | |             |(_____)| |      \n" +ChatColor.DARK_RED +
            ChatColor.DARK_RED +"| (      | (         | |   | |              |(      | |      \n" +ChatColor.DARK_RED +
            ChatColor.DARK_RED +"| (____/\\| )      ___) (___| (____/\\       | )      | (____/\\\n" +ChatColor.DARK_RED +
            ChatColor.DARK_RED +"(_______/|/       \\_______/(_______/       |/       (_______/\n" +ChatColor.DARK_RED +
            "                                                        \n"+ ChatColor.RESET + " " ;
    
  //prefix 
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage((Object)ChatColor.GREEN + "<----------------------->");

        //name
        Bukkit.getConsoleSender().sendMessage(String.valueOf(this.nombre));
        //name

        //registrar
        this.registrarComandos();
        Bukkit.getConsoleSender().sendMessage(String.valueOf(
                ChatColor.GREEN +"Registrando comandos...\n"+ ChatColor.GREEN +"    Comandos registrados correctamente.\n"+
                        " "));
        this.registerEvents();
        Bukkit.getConsoleSender().sendMessage(String.valueOf(
                ChatColor.GREEN +"Registrando eventos...\n"+ ChatColor.GREEN +"     Eventos registrados correctamente.\n"+
                        " "));
        this.registerConfig();
        Bukkit.getConsoleSender().sendMessage(String.valueOf(
                ChatColor.GREEN +"Registrando configuracion...\n"+ ChatColor.GREEN +"   Configuracion registrada correctamente.\n"+
                        " "));
        //registrar

        Bukkit.getConsoleSender().sendMessage(String.valueOf(
                ChatColor.DARK_RED +"Plugin desarrollado por: epic7x3\n" + ChatColor.DARK_RED +"    Discord: https://discord.gg/cfsDKT496b\n" + "v:" + this.version +"\n"+
                " "));

        Bukkit.getConsoleSender().sendMessage((Object)ChatColor.GREEN + "<----------------------->");
    }

    //

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage((Object)ChatColor.DARK_RED + "<----------------------->");
        Bukkit.getConsoleSender().sendMessage(String.valueOf(this.nombre) + "\n Apagando todo...");
        Bukkit.getConsoleSender().sendMessage((Object)ChatColor.DARK_RED + "<----------------------->");
    }

    public void registrarComandos() {
        this.getCommand("epicpl").setExecutor((CommandExecutor)new ComandoPrincipal(this));
        this.getCommand("spawn").setExecutor((CommandExecutor)new ComandoSpawn(this));
        this.getCommand("dev").setExecutor((CommandExecutor)new ComandoDev(this));
        this.getCommand("evento").setExecutor((CommandExecutor)new ComandoEvent(this));
        this.getCommand("hammerban").setExecutor((CommandExecutor)new ComandoHammer(this));
       
    }

	public void registerEvents() {
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents((Listener)new EventJoin(this), (Plugin)this);
        pm.registerEvents((Listener)new EventDeadAzar(this), (Plugin)this);
        pm.registerEvents((Listener)new EventFirstJoin(this), (Plugin)this);
        pm.registerEvents((Listener)new EventHammer(this), (Plugin)this);
    }


}