from rest_framework import serializers
from .models import RealPerson

from main_data.person import Person


class PersonSerializer(serializers.Serializer):
    first_name = serializers.CharField(max_length=100)
    last_name = serializers.CharField(max_length=100)

    def create(self, validated_data):
        return Person(**validated_data)


class RealPersonSerializer(serializers.ModelSerializer):

    class Meta:
        model = RealPerson
        fields = '__all__'

    def create(self, validated_data):
        return RealPerson(**validated_data)

