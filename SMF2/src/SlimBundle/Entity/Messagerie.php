<?php

namespace SlimBundle\Entity;

/**
 * Messagerie
 */
class Messagerie
{
    /**
     * @var string
     */
    private $maildestinataire;

    /**
     * @var string
     */
    private $mailexpediteur;

    /**
     * @var string
     */
    private $message;

    /**
     * @var string
     */
    private $etat;

    /**
     * @var integer
     */
    private $idmessage;


    /**
     * Set maildestinataire
     *
     * @param string $maildestinataire
     *
     * @return Messagerie
     */
    public function setMaildestinataire($maildestinataire)
    {
        $this->maildestinataire = $maildestinataire;

        return $this;
    }

    /**
     * Get maildestinataire
     *
     * @return string
     */
    public function getMaildestinataire()
    {
        return $this->maildestinataire;
    }

    /**
     * Set mailexpediteur
     *
     * @param string $mailexpediteur
     *
     * @return Messagerie
     */
    public function setMailexpediteur($mailexpediteur)
    {
        $this->mailexpediteur = $mailexpediteur;

        return $this;
    }

    /**
     * Get mailexpediteur
     *
     * @return string
     */
    public function getMailexpediteur()
    {
        return $this->mailexpediteur;
    }

    /**
     * Set message
     *
     * @param string $message
     *
     * @return Messagerie
     */
    public function setMessage($message)
    {
        $this->message = $message;

        return $this;
    }

    /**
     * Get message
     *
     * @return string
     */
    public function getMessage()
    {
        return $this->message;
    }

    /**
     * Set etat
     *
     * @param string $etat
     *
     * @return Messagerie
     */
    public function setEtat($etat)
    {
        $this->etat = $etat;

        return $this;
    }

    /**
     * Get etat
     *
     * @return string
     */
    public function getEtat()
    {
        return $this->etat;
    }

    /**
     * Get idmessage
     *
     * @return integer
     */
    public function getIdmessage()
    {
        return $this->idmessage;
    }
}

