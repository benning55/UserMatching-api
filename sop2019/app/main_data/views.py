import urllib
import urllib.request
import json
from rest_framework import status
from rest_framework.response import Response
from rest_framework.decorators import api_view
from main_data.serializers import PersonSerializer
from json import JSONEncoder
# Create your views here.


class MyEncoder(JSONEncoder):
    def default(self, o):
        return o.__dict__


@api_view(['POST', ])
def person_view(request):
    """To start recieving data"""
    if request.method == 'POST':
        serializer = PersonSerializer(data=request.data)
        if serializer.is_valid():
            result = serializer.create(validated_data=request.data)
            print(f'{result.first_name} {result.last_name}')
            final_data = json.dumps(cls=MyEncoder, obj=result)
            # data_a = get_company_a_data()
            # print(data_a)
            # data_b = get_company_b_data()
            # payload = {
            #     'companyA': data_a,
            #     'companyB': data_b
            # }
            return Response(final_data, status=status.HTTP_200_OK)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


def get_company_a_data():
    """Get the data from company A"""
    url = "http://localhost:8200/companya"
    response = urllib.request.urlopen(url)
    data = json.loads(response.read())
    return data[0]


def get_company_b_data():
    """Get the data from company B"""
    url = "https://jsonplaceholder.typicode.com/todos/1"
    response = urllib.request.urlopen(url)
    data = json.loads(response.read())
    return data


