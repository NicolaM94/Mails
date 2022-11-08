package utilities

import logic.Contact
import javax.swing.text.html.ListView

/**
 * Removes the selecteditem from the observable source list and updates the listView passed as parameter
 */
fun removeContact (item :Contact, fromArray:MutableList<Contact>) :MutableList<Contact> {
    fromArray.remove(item)
    return fromArray
}