package io.github.codedbygabriel.util;

public class EventData {
	private String id;
	private String type;
	public actor actor;
	public repo repo;

	public class actor {
		private String login;

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}
	}

	public class repo {
		private String name;

		public String getFormatedName() {
			return this.name.substring(this.name.indexOf("/")+1);
		}

		public String getName() {
			return name;
		}
	}


	public String getType() {
		return type;
	}
}
