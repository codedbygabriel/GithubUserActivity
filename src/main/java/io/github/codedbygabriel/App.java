package io.github.codedbygabriel;


import io.github.codedbygabriel.util.EventData;
import io.github.codedbygabriel.util.JsonHandler;

import java.util.ArrayList;

public class App {
	public static void main(String[] args) {
		if (args.length > 0 && args[0] instanceof  String){
			JsonHandler jsonHandler = new JsonHandler();
			ArrayList<EventData> data = jsonHandler.constructEventList(args[0]);

			if (data != null)
			{
				int countHolder = 0;
				String typeHolder = null;
				String repoHolder = null;
				String formattedRepoHolder = null;
				String autor;
				for (EventData event: data)
				{
					autor = event.actor.getLogin();

					if (countHolder == 0 && typeHolder == null && repoHolder == null){
						// Primeira iteraçao
						countHolder++;
						typeHolder = event.getType();
						repoHolder = event.repo.getName();
						formattedRepoHolder = event.repo.getFormatedName();
						// passa pra proxima iteração
						continue;
					}

					if (event.getType().equalsIgnoreCase(typeHolder) && event.repo.getName().equalsIgnoreCase(repoHolder)){
						// Se ainda for a mesma ação, no mesmo repositório
						countHolder++;
						continue;
					}

					// se nada disso for verdade, significa que estamos em outro repositório ou outra açao / event... portanto resetamos a contagem e parametros.
					// Mas antes, temos que printar.
					System.out.printf("Type: %s | %d Times | Onto %s | Author: %s%n%n", typeHolder, countHolder, formattedRepoHolder, autor);
					// reset
					countHolder = 1;
					typeHolder = event.getType();
					repoHolder = event.repo.getName();
					formattedRepoHolder = event.repo.getFormatedName();

				}
			}

		} else {
			System.out.println("Not enough arguments provided, please try the following example.\n" +
					"GithubUserActivity \"Username\"");
		}
	}

}
