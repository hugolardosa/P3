package aula12.ex2.plugins;

import aula12.ex2.IPlugin;

public class Plugin1 implements IPlugin {

    @Override
    public void fazQualQuerCoisa() {
        System.out.println("Este é o meu plugin 1");
    }
}

