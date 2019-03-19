struct ELE {
    long val;
    struct ELE *next;
} *list_ptr;

/* max_list - Find the maximum element in a linked list */
long max_list(list_ptr temp){
    long max_element = 0;
    while (temp) {
        if(temp->val > max_element) {
            max_element = temp->val;
        }
        temp = temp->next;
    }
    return max_element;
}

