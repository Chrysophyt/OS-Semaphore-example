#include<stdio.h>

int main(){
    printf("\nHow big the buffer : ");
    int BUFF_SIZE, in, out, produce, consume, choice = 0;
    in = 0;
    out = 0;
    scanf("%d", &BUFF_SIZE);
    int *buffer = new int[BUFF_SIZE];
    
    while(choice != 3) {
        printf("\n1.Produce \t2.Consume \t3.Exit");
        printf("\nEnter your choice: ");
        scanf("%d", &choice);
        switch (choice) {
        case 1:
            if((in+1)%(BUFF_SIZE)==out) 
                printf("\nBuffer is full.");
            else {
                printf("\nEnter the value: ");
                scanf("%d", &produce);
                buffer[in] = produce;
                in = (in+1)%BUFF_SIZE;
            }
            break;
        case 2:
            if(in==out) 
                printf("\nBuffer is Empty.");
            else {
                consume = buffer[out];
                printf("\nThe consumed value is %d", consume);
                out = (out+1)%BUFF_SIZE;
            }
            break;
        }
    }
}