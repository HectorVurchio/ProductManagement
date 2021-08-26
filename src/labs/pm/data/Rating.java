/**
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the license, or 
* (at your option) later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARANTY, witout even the implied waranty at
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. see the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>
*/

package labs.pm.data;

public enum Rating{
	NOT_RATED("Zero Stars"),
	ONE_STAR("One Star"),
	TWO_STAR("Two Stars"),
	THREE_STAR("Three Stars"),
	FOUR_STAR("Four Stars"),
	FIVE_STAR("Five Stars");
	private String stars;
	
	private Rating(String stars){
		this.stars = stars;
	}
	
	public String getStars(){
		return this.stars;
	}
}

/*
	NOT_RATED("\u2606\u2606\u2606\u2606\u2606"),
	ONE_STAR("\u2605\u2606\u2606\u2606\u2606"),
	TWO_STAR("\u2605\u2605\u2606\u2606\u2606"),
	THREE_STAR("\u2605\u2605\u2605\u2606\u2606"),
	FOUR_STAR("\u2605\u2605\u2605\u2605\u2606"),
	FIVE_STAR("\u2605\u2605\u2605\u2605\u2605");
	
*/