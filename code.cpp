#include<iostream>
using namespace std;
struct Node{
	int data;
	Node*next;
}; 
Node* AddHead(Node*head, int value){
    Node* temp =new Node(); // Kh?i t?o node temp v?i data = value
    temp->data=value;
    if(head == NULL){
        head = temp; // //N?u linked list dang tr?ng thì Node temp là head luôn
    }else{
        temp->next = head; // Tr? next c?a temp = head hi?n t?i
        head = temp; // Ð?i head hi?n t?i = temp(Vì temp bây gi? là head m?i mà)
    }
    return head;
}

void print(Node*p)
{
	while(p!=NULL){
		cout<< p->data<<"  ";
	}
}
int main(){
	Node*head=new Node();
	head->data=4;
	head->next=NULL;
	for(int i=1;i<5;i++){
		AddHead(head,i);
	}
}
