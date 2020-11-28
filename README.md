# CursoAppium
Curso da udemy sobre automacao mobile: https://www.udemy.com/course/testes-appium/

#Instalar Android:

	1- Baixar versão mais atualizada do Android Studio
		h ttps://developer.android.com/studio/index.html?hl=pt-br

	2 - Durante a instalação vá em: Custom -> marcar SDK, AVD, etc... (irá baixar e atualizar pacotes)
	
	3 - Vá em: Configure->"SDK Manager" e marque as seguintes opções:
		SDK platforms: Informe a versão do android que você irá testar
		SDK Tools: 
			Android SDK Build tools 
			Android Emulator
			Android SDK Plataform-tools
			Android SDK tools
	
	4 - Copie o Android SDK location, esse será o nosso ANDROID_HOME
			Ex: C:\Users\tailon\AppData\Local\Android\Sdk

	5 - Clique 'OK' e o sistema começará a baixar as dependências requisitadas.
	
#Configurar variáveis de ambiente Android:

	1 - Painel de Controle\Sistema e Segurança\Sistema -> Configurações Avançadas do Sistema -> Variáveis de ambiente
	
		Em Variáveis do sistema->Novo:
		
			ANDROID_HOME = Android SDK location copiado anteriormente
			Path->editar: no início adicione: 
				%ANDROID_HOME%\tools;
				%ANDROID_HOME%\tools\bin;
				%ANDROID_HOME%\platform-tools;

	2 - Abra um novo CMD e digite: 
		- adb + enter (Deve aparecer algumas informações do Android Debug Bridge) -> Está em: \platform-tools
		- emulator (Deve aparecer algumas informações do Emulador) -> Está em: \tools
		- uiautomatorviewer (Deve abrir a tela do UI Automator Viewer) -> Está em: \tools\bin

#Criar um emulador de dispositivo Android:
	
	1 - Star a new Android Studio Project
	2 - Empty project
	3 - Em AVD Manager -> Crie um novo Android Virtual Device (escolha a versão do android)
	
	Você pode executar pelo Android Studio ou pelo emulador:
	
		- Abrir cmd e digite emulator -list-avds
		- Vai aparecer todos o emuladores criados
		- Para executar o emulador você precisa estar em um diretório específico %ANDROID_HOME%\tools
		- Digite emulator @nome_do_seu_emulador 

#Instalar Appium:
	
	https://github.com/appium/appium-desktop/releases
	Obs.: A versão usada no curso é a 1.3.2 (mas instalamos a mais atual)
	
#Habilitar opção de desenvolvedor no celular físico:
	
	1- Ativar modo desenvolvedor: 
		- Ir em Configurações -> Informações do Software 
		- Clique no número da versão várias vezes até aparecer uma mensagem dizendo que o modo desenvolvedor está ativado
		- Volte no menu Configurações, deve ter aparecido "Opções do Desenvolvedor"
		- Habilitar modo de depuração USB

#Inspecionar app celular ou emulador:
	
	1 - Abrir Appium
	2 - Clicar em: Start Server
	3 - Clicar em: Start Inspector Session
	4 - Informar as desired capabilities do APP:
		platformName 	= Android
	    deviceName		= Nome do seu device (Comando adb devices no cmd)
	    automationName 	= uiautomator2
	    appPackage 		= caminho do pacote do app criado pelos developers
	    appActivity 	= nome dado ao app pelos developers
	5 - Clique em: Start Session, deve aparecer a tela do app

#Como pegar o appPackage e appActivity do APP:

	1 - No Cmd informe o comando adb shell
	2 - Abra o app que vc quer testar e de volta no cmd informe o comando: 
		
		dumpsys window windows | grep -E "mFocusedApp" (Cuidado com as aspas!)
	
	3 - Deve aparecer as informações do seu app:
		
		Ex.: mFocusedApp=AppWindowToken{e31692e token=Token{7c15fa9 ActivityRecord{db38730 u0 com.google.android.youtube/com.google.android.apps.youtube.app.WatchWhileActivity t254}}}
		
		Onde: 
			com.google.android.youtube = appPackage
			com.google.android.apps.youtube.app.WatchWhileActivity = appActivity


