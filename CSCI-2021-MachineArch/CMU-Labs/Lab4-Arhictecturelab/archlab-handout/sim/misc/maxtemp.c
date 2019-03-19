struct ELE {
    long val;
    struct ELE *next;
} *list_ptr;

/* max_list - Find the maximum element in a linked list */
long max_list(list_ptr ls)
{
    long max_element = 0;
    while (ls) {
        if(ls->val > max_element) {
            max_element = ls->val;
        }
        ls = ls->next;
    }
    return max_element;