package io.spring.sessionsservice;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table("sessions")
public class Session {
	@Id
	private long   id;
	private String title;
	private String timeslot;
	private String speakers;
	private String companies;
	private String room;
	private String day;

	public String getCompanies() {
		return companies;
	}

	public void setCompanies(String companies) {
		this.companies = companies;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(String timeslot) {
		this.timeslot = timeslot;
	}

	public String getSpeakers() {
		return speakers;
	}

	public void setSpeakers(String speakers) {
		this.speakers = speakers;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Session session = (Session) o;
		return id == session.id && Objects.equals(title, session.title) && Objects.equals(timeslot,
				session.timeslot) && Objects.equals(speakers, session.speakers) && Objects.equals(companies,
				session.companies) && Objects.equals(room, session.room) && Objects.equals(day, session.day);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, timeslot, speakers, companies, room, day);
	}


}
