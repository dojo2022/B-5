package model;

import java.io.Serializable;

public class Characters implements Serializable{

		private String id;
		private String user_id;
		private String character_name;
		private String character_status;
		private String character_image;
		private String character_point;
		private String character_id;

		public Characters(String id, String user_id, String character_name, String character_status,
				String character_image, String character_point, String character_id) {
			super();
			this.id = id;
			this.user_id = user_id;
			this.character_name = character_name;
			this.character_status = character_status;
			this.character_image = character_image;
			this.character_point = character_point;
			this.character_id = character_id;
		}

		public Characters() {
			super();
			this.id = "";
			this.user_id = "";
			this.character_name = "";
			this.character_status = "";
			this.character_image = "";
			this.character_point = "";
			this.character_id = "";
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getUser_id() {
			return user_id;
		}

		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}

		public String getCharacter_name() {
			return character_name;
		}

		public void setCharacter_name(String character_name) {
			this.character_name = character_name;
		}

		public String getCharacter_status() {
			return character_status;
		}

		public void setCharacter_status(String character_status) {
			this.character_status = character_status;
		}

		public String getCharacter_image() {
			return character_image;
		}

		public void setCharacter_image(String character_image) {
			this.character_image = character_image;
		}

		public String getCharacter_point() {
			return character_point;
		}

		public void setCharacter_point(String character_point) {
			this.character_point = character_point;
		}

		public String getCharacter_id() {
			return character_id;
		}

		public void setCharacter_id(String character_id) {
			this.character_id = character_id;
		}


}
