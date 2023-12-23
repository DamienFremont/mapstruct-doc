INSTALL (WIN, DEB, VSC, JAVA)
===================================

This documentation is intended for people using : OS=Windows, IDE=Visual Studio Code, LANG=Java (and WSL : SDKMAN needs WSL to run with Windows).

Summary :
1. Manual installation steps for older versions of WSL
2. How to Access Your Linux (WSL) Files in Windows 10
3. Linux Dev on Windows with WSL and VS Code
4. How to get started (README.md)
5. Java build tools in VS Code
6. What’s New Between Java 11 and Java 17 ?

---

## 1. Manual installation steps for older versions of WSL

Follow instructions from https://learn.microsoft.com/en-us/windows/wsl/install-manual

TLDR / Summary :

1. $ `dism.exe /online /enable-feature /featurename:Microsoft-Windows-Subsystem-Linux /all /norestart`
2. $ `dism.exe /online /enable-feature /featurename:VirtualMachinePlatform /all /norestart`
3. download & install https://wslstorestorage.blob.core.windows.net/wslblob/wsl_update_x64.msi
4. $ `wsl --set-default-version 2`
5. Install your Linux distribution of choice
    1. Open the Microsoft Store https://aka.ms/wslstore
    3. select your favorite Linux distribution (ex: 'Debian')
    4. From the distribution's page, select "Get".
    5.  create a user account and password for your new Linux distribution.
6. On Debian :
    1. $ `sudo apt install zip`
    1. $ `sudo apt install unzip`
    2. $ `sudo apt install wget`
    3. $ `sudo apt install curl`
    4. $ `sudo apt install git`

---

## 2. How to Access Your Linux (WSL) Files in Windows 10

Follow instructions from https://www.howtogeek.com/426749/how-to-access-your-linux-wsl-files-in-windows-10/

TLDR / Summary :

1. on Debian :
    1. $ `explorer.exe .`

---

## 3. Linux Dev on Windows with WSL and VS Code

Follow instructions from https://devblogs.microsoft.com/commandline/an-in-depth-tutorial-on-linux-development-on-windows-with-wsl-and-visual-studio-code/

TLDR / Summary :

1. Download VSC https://code.visualstudio.com/
2. on VSC:
    1. Install 'Remote – WSL' extension. https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-wsl
3. on Debian:
    2. $ `cd <MY PROJECT>`
    2. $ `code .`

---

## 4. How to get started (README.md)

Follow instructions from [README.md](README.md)

TLDR / Summary :

1. On VSC :
    1. open terminal (Ctrl+Shift+`)
    2. check it's your Linux VM path (ex: 'damien@DESKTOP-HGVSV60$' ...not Windows path)
2. install
    1. $ `curl -s "https://get.sdkman.io" | bash`
    2. $ `bash` (refresh env)
    3. $ `sdk env` (ex print: "sdk install java 17.0.2-tem")
    4. $ `sdk install java 8.0.392-tem`
    5. $ `sdk install maven 3.9.6`
3. compile
    1. $ `sdk use java 8.0.392-tem` 
    2. $ `mvn clean install -DskipTests`
4. test
    1. $ `mvn install`

---

## 5. Java build tools in VS Code

Follow instructions from https://code.visualstudio.com/docs/java/java-build

TLDR / Summary :

1. Gradle for Java https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-gradle
2. Extension Pack for Java https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack
3. Project Manager for Java https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-dependency
4. Test Runner for Java https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-test
