package org.example.service.webserver;

/**
 * Настройки для запуска веб-сервера
 */
public class Options {
	/**
	 * Порт, в адресной строке это значение после адреса: http://address:port?parameters
	 */
	public int port;

	/**
	 * Путь к папке, в которой лежат статичные файлы веб-интерфейса, например, файл index.html
	 */
	public String wwwRoot;

	/**
	 * Количество одновременно запускаемых потоков
	 */
	public int threadCount;
	
	public Options() {
		port = 8000;
		wwwRoot = "./www";
		threadCount = 16;
	}

	public Options(String wwwRoot) {
		this.port = 8000;
		this.wwwRoot = wwwRoot; // ./www
		this.threadCount = 16;
	}
}
