package com.heitor.cursomc;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Banner {

	@SuppressWarnings("static-access")
	public static void bannerBoasVindas() {
				System.out.println("=====================================================================================");
		 		System.out.println("   |                             |-|                      #   ___                    ");
				System.out.println("   |.===.         ,,,,,         _|_|_         ((__))      #  <_*_>           |/      ");
				System.out.println("   {}o o{}       /(o o)         (o o)          (00)       #  (o o)         (o o)     ");
				System.out.println("ooO--(_)--Ooo-ooO--(_)--Ooo-ooO--(_)--Ooo-nn--(o__o)--nn--8---(_)--Ooo-ooO--(_)--Ooo-");
				System.out.println("=====================================================================ooO=========Ooo=");
				System.out.println("                                  OPERANDO                            \\\\  (o o)  //  ");
				System.out.println("===========================================================================(_)=======");
				System.out.println("         _/_/_/    _/_/_/      _/_/_/      _/          _/     _/_/_/_/    _/_/_/      ");
				System.out.println("      _/            _/      _/             _/          _/    _/          _/    _/    ");
				System.out.println("       _/_/        _/        _/_/          _/    _/    _/   _/_/_/      _/_/_/      ");
				System.out.println("          _/      _/            _/         _/  _/  _/  _/  _/          _/    _/      ");
				System.out.println("   _/_/_/      _/_/_/    _/_/_/            _/  _/   _/ _/ _/_/_/_/    _/_/_/          ");
				System.out.println("=====================================================================================");
			
			try {
				Thread.currentThread().sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	public static void mostraIp() {

		try {

			String ipDaMaquina = InetAddress.getLocalHost().getHostAddress();
			String nomeDaMaquina = InetAddress.getLocalHost().getHostName();

			System.out.println("======================================================================================");
			System.out.println("||     |            ||                                                              ||");
			System.out.println("||     |.===.       ||    ENDERECO SISTEMA: http://" + ipDaMaquina + ":8080/              ||");
			System.out.println("||     {}o o{}      ||    NOME DA MAQUINA: " + nomeDaMaquina + "                          ||");
			System.out.println("||  ooO--(_)--Ooo-  ||                                                              ||");
			System.out.println("======================================================================================");
		} catch (UnknownHostException e) {
			System.out.println("Não foi Possivel Pegar o Endereço da Maquina.");
			e.printStackTrace();
		}
	}
}
